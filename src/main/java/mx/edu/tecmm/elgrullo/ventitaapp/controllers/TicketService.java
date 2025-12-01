
package mx.edu.tecmm.elgrullo.ventitaapp.controllers;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import mx.edu.tecmm.elgrullo.ventitaapp.models.DetalleVentas;
import mx.edu.tecmm.elgrullo.ventitaapp.models.Venta;

/**
 *Clase que imprime un ticket 
 * fue refactorizado por GEMINI 
 * @GEMINI
 */
public class TicketService {
    // Comandos ESC/POS básicos
    private static final String ESC = "\u001B";
    private static final String GS = "\u001D";
    private static final String INIT = ESC + "@"; // Inicializar impresora
    private static final String ALIGN_LEFT = ESC + "a" + "\u0000";
    private static final String ALIGN_CENTER = ESC + "a" + "\u0001";
    private static final String ALIGN_RIGHT = ESC + "a" + "\u0002";
    private static final String BOLD_ON = ESC + "E" + "\u0001";
    private static final String BOLD_OFF = ESC + "E" + "\u0000";
    private static final String CUT_PAPER = GS + "V" + "\u0041" + "\u0000"; // Cortar papel

    // Ancho aproximado para 80mm
    private static final int MAX_WIDTH = 48;

    public void printVenta(Venta venta) {
        // 1. Buscar el servicio de impresión (la impresora predeterminada)
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();

        if (service == null) {
            System.err.println("No se encontró ninguna impresora predeterminada.");
            return;
        }

        try {
            // DETECCION INTELIGENTE:
            String printerName = service.getName().toLowerCase();
            boolean isVirtualPrinter = printerName.contains("pdf") || 
                                       printerName.contains("writer") || 
                                       printerName.contains("xps") || 
                                       printerName.contains("microsoft");

            if (isVirtualPrinter) {
                // Estrategia GRAFICA (Para PDF)
                System.out.println("Imprimiendo en modo GRAFICO (PDF Detectado: " + service.getName() + ")");
                printGraphicVenta(venta, service);
            } else {
                // Estrategia RAW (Para Térmica)
                System.out.println("Imprimiendo en modo RAW ESC/POS (Térmica Detectada: " + service.getName() + ")");
                printRawVenta(venta, service);
            }

        } catch (Exception e) {
            System.err.println("Error al imprimir el ticket: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método para imprimir en impresoras térmicas usando comandos ESC/POS directos.
     */
    private void printRawVenta(Venta venta, PrintService service) throws Exception {
        String ticketContent = buildTicketText(venta, true); // true = usa comandos ESC/POS
        
        DocPrintJob job = service.createPrintJob();
        byte[] bytes = ticketContent.getBytes("CP437"); 
        Doc doc = new SimpleDoc(bytes, DocFlavor.BYTE_ARRAY.AUTOSENSE, null);
        PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
        job.print(doc, attr);
    }

    /**
     * Método para imprimir en impresoras PDF usando gráficos Java (evita corrupción).
     */
    private void printGraphicVenta(Venta venta, PrintService service) throws PrinterException {
        // Obtenemos el contenido sin comandos raros, solo texto limpio
        String ticketText = buildTicketText(venta, false);
        
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintService(service);
        
        // Asignamos la tarea de dibujo
        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return NO_SUCH_PAGE;
                }

                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                
                // Usamos fuente Monospaced para que las columnas se alineen correctamente
                g2d.setFont(new Font("Monospaced", Font.PLAIN, 10)); 
                
                String[] lines = ticketText.split("\n");
                int y = 15; // Posición inicial Y
                
                for (String line : lines) {
                    g2d.drawString(line, 10, y);
                    y += 12; // Salto de línea (altura de la fuente + espaciado)
                }

                return PAGE_EXISTS;
            }
        });

        job.print();
    }

    /**
     * Construye el texto del ticket.
     * @param useControlCodes Si es true, añade códigos ESC para cortar papel y negritas.
     */
    private String buildTicketText(Venta venta, boolean useControlCodes) {
        StringBuilder sb = new StringBuilder();

        String cInit = useControlCodes ? INIT : "";
        String cAlignLeft = useControlCodes ? ALIGN_LEFT : "";
        String cAlignCenter = useControlCodes ? ALIGN_CENTER : "";
        String cAlignRight = useControlCodes ? ALIGN_RIGHT : "";
        String cBoldOn = useControlCodes ? BOLD_ON : "";
        String cBoldOff = useControlCodes ? BOLD_OFF : "";
        String cCut = useControlCodes ? CUT_PAPER : ""; // En PDF no necesitamos texto de "corte"

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaStr = sdf.format(venta.getFechaRegistro());

        // --- ENCABEZADO ---
        sb.append(cInit);
        sb.append(cAlignCenter);
        sb.append(cBoldOn);
        sb.append("Ventita APP\n");
        sb.append(cBoldOff);
        sb.append("\n");
        
        sb.append(cAlignLeft);
        sb.append("Fecha: ").append(fechaStr).append("\n");
        sb.append("Venta al publico\n");
        sb.append("Folio: ").append(venta.getId()).append("\n");
        sb.append(drawLine());
        
        // --- COLUMNAS ---
        sb.append(cBoldOn);
        sb.append(String.format("%-5s %-30s %10s\n", "CANT", "PRODUCTO", "PRECIO"));
        sb.append(cBoldOff);
        sb.append(drawLine());

        // --- DETALLES ---
        List<DetalleVentas> detalles = venta.getDetalles();
        if (detalles == null) detalles = new ArrayList<>();

        for (DetalleVentas det : detalles) {
            String nombreProducto = det.getDescripcion();
            if (nombreProducto.length() > 28) {
                nombreProducto = nombreProducto.substring(0, 28);
            }
            
            String precioStr = String.format("$ %.2f", det.getPrice() * det.getCant());
            
            sb.append(String.format("%-5d %-30s %10s\n", 
                    det.getCant(), 
                    nombreProducto, 
                    precioStr));
        }

        // --- TOTALES ---
        sb.append(drawLine());
        sb.append(cAlignRight);
        sb.append(cBoldOn);
        sb.append("TOTAL: $ ").append(String.format("%.2f", venta.getTotal())).append("\n");
        sb.append(cBoldOff);
        
        // --- PIE DE PAGINA ---
        sb.append(cAlignCenter);
        sb.append("\n");
        sb.append("Gracias por su compra\n");
        
        if (useControlCodes) {
            sb.append("\n\n\n");
            sb.append(cCut);
        }

        return sb.toString();
    }

    private String drawLine() {
        return "-".repeat(MAX_WIDTH) + "\n";
    }
}
