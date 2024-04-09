package week13;

public class Diamond {
        // Variables to hold system values
        private int carats;
        private double value;

        //Constructor to store in carats and value into the Diamond object
        public Diamond(int carats, double value) {
            this.carats = carats;
            this.value = value;
        } // end of Diamond constructor

        // Getter method to get the carats
        public int getCarats() {
            return carats;
        } // end of getCarats method

        // Getter to get the value
        public double getValue() {
            return value;
        } // end of getValue method

} // end of Diamond class


