public class Exemple2 {

    enum ColorPanel {
        RED("#FF0000"), GREEN("#FF0000"),
        LIGHT_GREEN("#90EE90"), BLUE("#0000FF");
        private final String hexaCode;

        ColorPanel(String hexaCode) {
            this.hexaCode = hexaCode;
        }
        /**
         * @return the hexaCode
         */
        public String getHexaCode() {
            return hexaCode;
        }

        @Override
        public String toString() {
            return super.toString() + "["+ hexaCode + "]";
        }
    }

    public static void main(String[] args) {
        ColorPanel c = ColorPanel.BLUE;
        System.out.println(c.getHexaCode());
        System.out.println(c);
    }
}
