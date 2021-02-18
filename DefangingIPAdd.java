public class DefangingIPAdd {

    // use split
    public static String defangIPaddr1(String address) {
        String ip ="";
        String[] ipAdd = address.split("[.]");

        for(int i = 0; i< ipAdd.length; i++) {
            ip = ip.concat(ipAdd[i]);
            if(i == ipAdd.length -1)
                break;
            ip = ip.concat("[.]");
        }
        return ip;
    }

    //use replace
    public String defangIPaddr(String address) {
        return null != address ?address.replace(".","[.]"):address;
    }
}
