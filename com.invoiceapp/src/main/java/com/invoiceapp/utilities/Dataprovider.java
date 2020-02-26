package com.invoiceapp.utilities;

import com.invoiceapp.utilities.Globalconstants;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Dataprovider {
	
    public static String getData(String sheet, String field, String row, String column) throws FilloException {
    	Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection(Globalconstants.datasheetpath);
        String strQuery="Select * from "+sheet+" where "+field+" = "+"'"+row+"'";
        Recordset recordset=connection.executeQuery(strQuery);
        String value ="";
        while(recordset.next()){
        value = recordset.getField(column);
        }
        //System.out.println(recordset.getCount());
        //System.out.println(recordset.getFieldNames());
        try {
        recordset.close();
        connection.close();
        }catch(Exception e) {
        	System.out.println("Unable to close the file connection");
        } finally {
            recordset.close();
            connection.close();
        }
        return value;
    }
}
