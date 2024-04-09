package week12;

//=================================================================================================
public class MyJavaProgram {
    //-------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        int index;

        for (index = 0; index < args.length; index++) {
            System.out.println("Item " + index + " is " + args[index]);
        }

        for(String temporaryData : args){
            System.out.println(temporaryData);

        }
    }
//-------------------------------------------------------------------------------------------------
}
//=================================================================================================
