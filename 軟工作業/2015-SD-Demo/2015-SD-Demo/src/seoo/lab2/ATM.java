package seoo.lab2;

/** ATM.java created on 2011/9/22
 * 
 * This file is a part of OOP Design Pattern Lab. materials.
 *
 * @author Pin-Ying Tu
 * @version 1.0
 */
public class ATM
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        ATMModel model = new ATMModel();
        model.initialize();
        ATMTextUI ui = new ATMTextUI(model);
        ui.show();
    }

}
