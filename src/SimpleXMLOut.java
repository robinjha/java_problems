

public class SimpleXMLOut {
    public static void main(String args[]) {
        String[] input = {"John Doe,123-456-7890", "Bob Smith,123-555-1212"};
        String[] line = new String[2];

        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        System.out.println("<root>");
        System.out.println("    <members>");
        for (int i=0; i < input.length; i++) {
            line = input[i].split(",");
            System.out.println("        <member>");
            System.out.println("            <name>" + line[0] + "</name>");
            System.out.println("            <phone>" + line[1] + "</phone>");
            System.out.println("        </member>");
        }
        System.out.println("    </members>");
        System.out.println("</root>");
    }
}

