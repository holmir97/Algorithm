public class AddressBookWithSQLITE {
    public static void main(String args[]){
        PasswordInfo p;
        PasswordDAO passwordDAO = new PasswordDaoImpl();

        System.out.println("<inserting...>");
        p = new PasswordInfo("https://www.smu.ac.kr","smu", "abcde");
        passwordDAO.insert(p);
        p = new PasswordInfo("https://www.smu2.ac.kr","smu2", "abcde");
        passwordDAO.insert(p);

        // Print all
        System.out.println("\n<finding all...>");
        for (PasswordInfo pi : passwordDAO.findAll()) {
            System.out.println("->" + pi);
        }

        // Change ID
        System.out.println("\n<updating...>");
        p = passwordDAO.findByKey("https://www.smu2.ac.kr");
        p.setId("smu1");
        passwordDAO.update(p);

        // Check new ID
        System.out.println("<see if updated>");
        p = passwordDAO.findByKey("https://www.smu2.ac.kr");
        if (p != null) {
            System.out.println(p);
        }

        // Delete "https://www.smu2.ac.kr"
        System.out.println("\n<deleting...>");
        passwordDAO.delete(passwordDAO.findByKey("https://www.smu2.ac.kr"));


        // Print all after delete
        System.out.println("<finding all after deleting...>");
        for (PasswordInfo pi : passwordDAO.findAll()) {
            System.out.println("->" + pi);
        }
    }

}
