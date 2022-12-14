package Question3;

import java.util.Scanner;

public class Answer {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String carNo;
        int n=scanner.nextInt();
        CarPark carPark = new CarPark(n);
        String input=scanner.nextLine();
        input=scanner.next();
        while(true) {
            carNo = String.valueOf(input.charAt(5)-'0');
            int time=0;
            int c=7;
            while(input.charAt(c)!=')')
                time=time*10+ input.charAt(c++)-'0';
            char item=input.charAt(2);
            switch (item) {
                case 'A' -> {
                    if (carPark.searchParking(carNo) != 1 && carPark.searchPavement(carNo) != 1) {
                        carPark.arrival(carNo, time);
                    } else {
                        System.out.println("抱歉！该车辆已经存在了，请重新输入车牌号。");
                    }
                }
                case 'D' -> {
                    if (carPark.searchParking(carNo) == 1)//出来之前，要先看看车子有没有在停车场里面，如果在
                    {
                        Car car = carPark.leave(carNo,time);//接受返回值
                        int dur = (int) (time-car.ArriveTime);
                        double fee = dur * carPark.price;
                        System.out.println("离开车辆的车牌号为：" + carNo);
                        System.out.println("停车费用共计：" + fee + "元");
                    } else if (carPark.searchPavement(carNo) == 1)//如果停车场上没有，就在便道上找，如果找到了这辆车
                    {//那么就把这辆车从便道上取出来，使它直接从便道上离开
                        Car car = carPark.leavepavement(carNo);
                    } else //否则提示便道上也没有这辆车，那就提示没车
                    {
                        System.out.println("抱歉！停车场和便道内都没有找到车牌为" + carNo + "的车。");
                    }
                }
                case 'E'->{
                    System.out.println("程序已退出");
                    System.exit(0);
                }
            }
            input=scanner.next();
        }
    }
}
