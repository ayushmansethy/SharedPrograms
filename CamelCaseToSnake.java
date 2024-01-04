public class CamelCaseToSnake {
    public static void main(String[] args) {
        String str = "ayushmanSethyMyNameIs"; 

        StringBuilder result = new StringBuilder() ;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                result.append("_");
                result.append(Character.toLowerCase(str.charAt(i)));
            }else{
                result.append(Character.toLowerCase(str.charAt(i)));
            }
        }
        System.out.println(result);
    }

}
