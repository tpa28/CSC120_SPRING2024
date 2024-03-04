package week8;

public class Kindle {
    // Variables to hold system values
    private int numberOfPages, currentPage;

    // Constructor for Kindle to accept values
    public Kindle(int numberOfPages) {
        this.numberOfPages = numberOfPages;
        this.currentPage = 1;
    } // end of Kindle constructor

    // Overridden toString method for printing the object
    public String toString() {
        return "Page " + currentPage + " of " + numberOfPages + ".";
    } // end of toString method

    // Method to increase current page number
    public void turnPages() {
        //currentPage++;
        turnPages(1);  // Default increment by 1
    } // end of turnPages method

    // Overloaded method of turnPages to increase current page number
    public void turnPages(int increment) {
        int nextPages;
        nextPages = currentPage + increment;

        if (nextPages <= numberOfPages) {
            currentPage = nextPages;
        } else {
            System.out.println("Turning " + increment + " pages would take you past the last page.");
            currentPage = numberOfPages;
            System.out.println("You are now on             : " + this);
        }
    } // end of  overloaded turnPages method
//-------------------------------------------------------------------------------------------------
} // end of Kindle class
//=================================================================================================

