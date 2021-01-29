public class TimeMaking {


//    static int toInt( String x )
//            throws NumberFormatException {
//
//        int a = Integer.parseInt(x);
//
//        System.out.println(" a : " + a );
//        return a; }


    public static void main(String[] args) {

        String time="0902";
        String hh= time.substring(0,2);
        String mm=time.substring(2,4);


        int hour=Integer.valueOf(hh);
        int minute=Integer.valueOf(mm);
//		int hour = toInt(hh);
//		int minute = toInt(mm);
//
        //원래 시간 출력
        System.out.println("Input_Time : " + String.format("%02d", hour)+String.format("%02d", minute));

        //시간 base time 형식에 맞게 변환
        //hour
        switch(hour) {

            case 3:
            case 4:
                hour = 2;
                System.out.println("HOUR : " + String.format("%02d", hour));
                break;

            case 6:
            case 7:
                hour = 5;
                System.out.println("HOUR : " + String.format("%02d", hour));
                break;

            case 9:
            case 10:
                hour = 8;
                System.out.println("HOUR : " + String.format("%02d", hour));
                break;

            case 12:
            case 13:
                hour = 11;
                System.out.println("HOUR : " + String.format("%02d", hour));
                break;

            case 15:
            case 16:
                hour = 14;
                System.out.println("HOUR : " + String.format("%02d", hour));
                break;

            case 18:
            case 19:
                hour = 17;
                System.out.println("HOUR : " + String.format("%02d", hour));
                break;

            case 21:
            case 22:
                hour = 20;
                System.out.println("HOUR : " + String.format("%02d", hour));
                break;

            case 24:
            case 1:
                hour = 23;
                System.out.println("HOUR : " + String.format("%02d", hour));
                break;

        }

//minute
        minute=0;
        System.out.println("MINUTE : " + String.format("%02d", minute));



        System.out.println("Base_TIme : "  + String.format("%02d", hour) + String.format("%02d", minute));


    }
}