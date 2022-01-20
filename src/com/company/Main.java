package com.company;

public class Main {

    /*public static void main(String[] args) throws IOException {

        URL url = new URL(args[0]);
        URLConnection connection= url.openConnection();
        byte[] bites= connection.getInputStream().readAllBytes();
        String tag= "<" +args[1]+".*\\/?>";
        String s = new String(bites, StandardCharsets.UTF_8);


        BufferedReader br= new BufferedReader(new StringReader(s));
        br.readLine();
        Pattern pat= Pattern.compile(tag);
        try{

            while (true){
                String linia;
                Matcher m= pat.matcher(linia=br.readLine());
                if (m.find()){

                    int inici= m.start();

                    System.out.println(linia.substring(inici));

                }

            }
        }catch(Exception e){}
        br.close();


        url= new URL("https://docs.google.com/forms/u/0/d/e/1FAIpQLScE6sxLFb3BmCmT2TKHQH5ormS0qvjHwO-uTAR8MXaagBvSSQ/formResponse");
        connection=url.openConnection();



        OutputStreamWriter out= new OutputStreamWriter(connection.getOutputStream());
        connection.setDoOutput(true);

        out.write("entry.835030737=InjectantDades&entry.1616686619=No");
        out.close();
        connection.getInputStream();
    }*/
}
