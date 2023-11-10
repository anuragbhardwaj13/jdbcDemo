import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "Password-1");
        Statement smt=connection.createStatement();){

            Scanner scanner=new Scanner(System.in);
            boolean inputFlag=false;
            System.out.println("Do you want to enter any value?\nAnswer 'yes' or 'no':");
            String takeInput=scanner.next();
            if(takeInput.trim().equals("yes")){
                inputFlag=true;
                System.out.println("---------CREATE---------");
            }else{
                inputFlag=false;
            }
            while(inputFlag){

                int inputID= (int) (Math.random()*10);
                int inputAge=(int) (Math.random()*15);
                System.out.println("Enter First");
                String inputFirst=scanner.next();
                System.out.println("Enter Last");
                String inputLast=scanner.next();
                smt.executeUpdate("INSERT INTO Member values ("+inputID+","+inputAge+",'"+inputFirst+"','"+inputLast+"')");
                System.out.println("Do you want to enter more value?\nAnswer 'yes' or 'no':");
                takeInput=scanner.next();
                if(takeInput.toLowerCase().equals("yes")){
                    inputFlag=true;
                }else{
                    inputFlag=false;
                }
            }
            String strSelect = "select id, age, first, last from Member";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            int rowCount = 0;
            ResultSet rset = smt.executeQuery(strSelect);

            System.out.println("---------READ---------");
            System.out.println("id | age | first | last");
            while(rset.next()) {   // Repeatedly process each row
                int id = rset.getInt("id");  // retrieve a 'String'-cell in the row
                int age = rset.getInt("age");
                String first=rset.getString("first");
                String last=rset.getString("last");
                System.out.println(id+" | "+age+" | "+first+" | "+last);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);
            System.out.println("---------UPDATE---------");
            boolean updateflag=false;
            System.out.println("Do you want to update any record?\nAnswer 'yes' or 'no':");
            String updateValue=scanner.next();
            if(updateValue.toLowerCase().equals("yes")){
                updateflag=true;
            }else{
                updateflag=false;
            }
            while(updateflag){
                System.out.println("what user do you want to update?\nPlease enter ID:");
                int idToBeUpdated=scanner.nextInt();
                System.out.println("what field do you want to update?\nfor first name, enter 'first'\nfor last name, enter 'last'\n:");
                String fieldToBeUpdated=scanner.next();
                System.out.println("what fis the new value which you want?:");
                String valueToBeUpdated=scanner.next();
                try {
                    String sql="update Member set "+fieldToBeUpdated.toLowerCase().trim()+"='"+valueToBeUpdated+"' where id="+idToBeUpdated;
                    smt.executeUpdate(sql);
                    System.out.println("Updated Row");
                    ResultSet updateResult=smt.executeQuery("select * from Member where id="+idToBeUpdated);
                    System.out.println("id | age | first | last");
                    while(updateResult.next()){
                        System.out.println(updateResult.getInt("id")+" | "+updateResult.getInt("age")+" | "+updateResult.getString("first")+" | "+updateResult.getString("last"));
                    }
                    System.out.println("Do you want to update any more record?\nAnswer 'yes' or 'no':");
                    updateValue=scanner.next();
                    if(updateValue.toLowerCase().equals("yes")){
                        updateflag=true;
                    }else{
                        updateflag=false;
                    }

                }catch (SQLException exception){
                    System.out.println(exception);
                }

            }
            System.out.println("---------DELETE---------");
            boolean deleteflag=false;
            System.out.println("Do you want to Delete any record?\nAnswer 'yes' or 'no':");
            String deleteValue=scanner.next();
            if(deleteValue.toLowerCase().equals("yes")){
                deleteflag=true;
            }
            while(deleteflag) {
                System.out.println("what Record do you want to Delete?\nPlease enter ID:");
                int idToBeUpdated = scanner.nextInt();
                try {
                    String sql = "delete from Member where id=" + idToBeUpdated;
                    int isDeleted=smt.executeUpdate(sql);
                    if(isDeleted==1){
                        System.out.println("Record deleted successfully");
                    }else{
                        throw new SQLException("Id Not Found");
                    }
                    System.out.println("Do you want to Delete any more record?\nAnswer 'yes' or 'no':");
                    deleteValue = scanner.next();
                    if (deleteValue.toLowerCase().equals("yes")) {
                        deleteflag = true;
                    } else {
                        deleteflag = false;
                    }
                } catch (SQLException exception) {
                    System.out.println(exception.getMessage());
                    deleteflag=false;
                }
            }
            rowCount = 0;
            rset = smt.executeQuery(strSelect);

            System.out.println("---------FINAL TABLE---------");
            System.out.println("id | age | first | last");
            while(rset.next()) {   // Repeatedly process each row
                int id = rset.getInt("id");  // retrieve a 'String'-cell in the row
                int age = rset.getInt("age");
                String first=rset.getString("first");
                String last=rset.getString("last");
                System.out.println(id+" | "+age+" | "+first+" | "+last);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);

            }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}