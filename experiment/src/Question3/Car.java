package Question3;

public class Car {
    public String CarNum;//车牌号码
    public String Arrive;//存放车辆到达时间
    public String Leave;//存放车辆离开时间
    public long ArriveTime;//获取车辆到达时间
    public long LeaveTime;//获取车辆离开时间

    //设置车牌号码
    public void setCarNum(String CarNum)
    {
        this.CarNum=CarNum;
        Arrive=TimeSet.getTimeStamp(ArriveTime);//通过时间戳获取时间
    }
    //设置车辆到达时间和车辆到达状态
    public void setArriveTime(long ArriveTime)
    {
        this.ArriveTime=ArriveTime;//设置车辆到达的时间
    }
    //设置车辆离开时间和车辆离开状态
    public void setLeaveTime(long LeaveTime)
    {
        this.LeaveTime=LeaveTime;//设置车辆离开的时间
        Leave=TimeSet.getTimeStamp(LeaveTime);//通过时间戳获取时间
    }

    //返回车牌号码
    public String getCarNum()
    {
        return CarNum;
    }
    public int getTime(){
        return (int)((LeaveTime-ArriveTime)*10)/60000;
    }
    public String toString()
    {
        return "Car{" +
                "carNo='" + CarNum + '\'' +
                ", arrive='" + Arrive + '\'' +
                ", leave='" + Leave + '\'' +
                '}';
    }
}
