package Question3;

public class CarPark {
    CarQueue pavement=new CarQueue();//便道(链式队列)
    CarStack transitstation=new CarStack(3);//中转区(顺序栈)
    CarStack parking;//停车场(顺序栈)
    double price=3;//停车的单位时间费用为3元
    CarPark(int n){
        parking=new CarStack(n);
    }

//停车场业务
    /**
     * 功能：汽车驶入。 将carNo车牌的汽车驶入，如果停车场有车位则进入停车场，设定入场时间，否则在便道等待进入
     * 参数：
     * 	carNo -- 车牌信息
     * 返回值：成功与否
     */
    //当有车到达时，若停车场已满或便道上有等待车辆，则进入便道排队等待（入队）
    public boolean arrival(String CarNum,int time)
    {
        //创建一个对象代表刚进来的车
        Car car=new Car();
        //设置进来车辆的车牌号
        car.setCarNum(CarNum);

        //先看看停车场有没有空位置,如果停车场没有位置了，那么这个车直接进入便道等候
        if(parking.isFull())
        {
            pavement.offer(car);//刚来的车进去便道，要提示已经去了便道。
            System.out.println("由于停车场已经满了，车牌号为"+CarNum+"的车辆已经进入便道等待。");
        }
        //如果还有停车位，还要再看看便道上有没有车在等待
        else
        {
            //如果便道上还有其他车已经在等待，那么就便道上的车先进去停车，刚到的这个车要到便道上面等候
            if(!pavement.isEmpty())
            {
                parking.push((Car) pavement.poll());//便道上的车进入停车场
                pavement.offer(car);//刚来的车进入便道等候
            }
            //如果便道上是空的，那么这个车就可以直接进去停车场了
            else
            {
                car.setArriveTime(time);//目标车辆进车库，需要记下它的时间
            }
        }
        return parking.push(car);//刚来的车进去停车场，返回一个布尔型，验证它有没有成功进入车库
    }
    /**
     * 功能： 骑车驶离。将carNo车牌的汽车驶离停车场，设定离开时间，同时便道汽车进入停车场
     * 参数：
     * 	carNo -- 车牌信息
     * 返回值：离开汽车
     */
    //当停车场有车出场时，便道中排在最前的车辆先进入停车场（出队，并进栈）
    public Car leave(String CarNum,int time)
    {
        if(parking.isEmpty()) //如果车库是空的，就返回空值
        {
            return null;
        }
        //创建一个对象代表要出去的车,为空,最后赋值
        Car leaveCar=null;

        //先看看停车场是不是只有它自己一辆车,如果不止一辆车，在它之后进入的车辆必须先退出停车场为它让路，进入中转区
        //如果停车场里面只有它自己一辆车，它就可以直接自己出来，并记录出来的时间
        while(parking.length()>=1)
        {
            //创建对象代表退出停车场进入中转区的车
            Car carTransform=(Car) parking.pop();
            //用TransformNum来代表进去中转区的车的车牌号码
            String TransformNum=carTransform.getCarNum();
            //判断正从停车场出来的车的车牌号是不是和要离开的车的车牌号一样，如果一样，这辆车就是目标出来车辆，要记录它离开的时间
            if(TransformNum.equals(CarNum))
            {
                carTransform.setLeaveTime(time);
                leaveCar=carTransform;
            }
            //如果不一样，这个车不是目标车辆，不必记录时间，直接移到中转区就好
            else
            {
                transitstation.push(carTransform);//从停车场出来的车进去中转区
            }

        }
        //待目标辆车开出大门后，其他车辆再按原次序返回车场
        while(!transitstation.isEmpty())
        {
            parking.push(transitstation.pop());//从中转区出来的车进去停车场
        }
        return leaveCar;
    }
    public double charging(Car car)
    {
        return car.getTime()*price;
    }

    // 显示所有入库车辆信息
    public void showPark()
    {
        if(parking.isEmpty())
        {
            //当停车场没有车辆在等的时候，就提示没有车子在停车场
            System.out.println("停车场暂时没有停放车辆！");
        }
        //当停车场有车辆的时候，就输出它们的信息
        else
        {
            System.out.println("入场车辆的信息为：");
            parking.display();
        }
    }

    // 显示所有在便道上等待信息
    public void showWaiting()
    {
        if(pavement.isEmpty())
        {
            //当便道上没有车辆在等的时候，就提示没有车子在等待
            System.out.println("便道上暂时没有车辆在等待！");
        }
        else
        {
            //当便道上有车辆在等待的时候，就输出它们的信息
            System.out.println("正在便道上等待的车辆有：");
            pavement.display();
        }
    }

    //查找车辆是否在场
    public void searchCar(String carNo)
    {
        int flagInParking = searchParking(carNo);//查找车在不在停车场
        int flagInpavement = searchPavement(carNo);//查找车在不在便道
        if (flagInParking == 1)
        {
            System.out.println("车牌为" + carNo + "在停车场内。");
        }
        else if (flagInpavement == 1)
        {
            System.out.println("车牌为" + carNo + "在便道内。");
        }
        else
        {
            System.out.println("不好意思！找不到此车！");
        }
    }

    //查找便道上的车辆
    public int searchPavement(String CarNum){
        //停车场查找不到，就查找便道，查到了就提示该车辆在便道，并退出查找
        CarQueue tmpQueue=new CarQueue();//中间队列，存放取出来的车
        int flag=0;
        while(!pavement.isEmpty())
        {
            //用searchPavement存放便道的车辆车牌号码
            Car searchPavement=((Car) pavement.poll());
            if(searchPavement.getCarNum().equals(CarNum))
            {//在便道上查找到车辆
                flag=1;
            }
            tmpQueue.offer(searchPavement);	//停进中间队列
        }
        while (!tmpQueue.isEmpty())//当中间队列不为空的时候，要把取出来的车子都放回去
        {
            pavement.offer((Car) tmpQueue.poll());
        }
        return flag;
    }
    //查找停车场上的车辆
    public int searchParking(String CarNum)
    {
        int flag=0;
        //从停车场开始查找，查到了就提示该车辆在停车场，并退出查找
        while(!parking.isEmpty())
        {
            //用searchPark存放刚刚从停车场中取出来的车辆
            Car searchPark=parking.pop();
            if(searchPark.getCarNum().equals(CarNum))
            {
                //车牌号是CarNum的车辆现在在停车场！
                flag=1;
            }
            //取出来的车辆不是目标车辆，就把它先放进中转区里面
            transitstation.push(searchPark);
        }
        while (!transitstation.isEmpty())
        {//查找完毕，当中转区非空的时候，要把里面的车辆全都放回去停车场
            parking.push(transitstation.pop());
        }
        return flag;
    }

    //离开便道，这个跟查询便道的方法一样，要先确定有没有这辆车
    public Car leavepavement(String carNo)
    {
        Car leaveCar = null;	//用来指向我们想要离开的车辆
        CarQueue searchQueue=new CarQueue();//建一个新的队列作为中间队列
        while(!pavement.isEmpty())//如果便道不为空
        {
            Car pavementTopCar=(Car) pavement.poll();//便道上第一个车给取出来
            if(carNo.equals(pavementTopCar.getCarNum()))//看看是不是目标车辆
            {//如果是，就取出，并且提示已经离开了便道
                leaveCar=pavementTopCar;
                System.out.println("便道上车牌号为"+leaveCar.getCarNum()+"车辆已离开!");
            }
            else //如果不是目标车辆，就把它放进去中间队列里面
            {
                searchQueue.offer( pavementTopCar);
            }

        }
        //最后查找完毕，要把取出来放在中间队列里的车放回去便道
        while (!searchQueue.isEmpty()){
            pavement.offer((Car) searchQueue.poll());
        }
        return leaveCar;
    }
}
