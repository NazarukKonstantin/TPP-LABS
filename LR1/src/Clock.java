public class Clock implements Comparable<Clock> {
    private int hours;
    private int minutes;
    private int seconds;

    public Clock(int total_seconds){
        hours=total_seconds/3600;
        minutes=(total_seconds-hours*3600)/60;
        seconds=total_seconds-hours*3600-minutes*60;
    }

    public Clock(int seconds, int minutes, int hours){
        this.seconds=seconds;
        this.hours=hours;
        this.minutes=minutes;
    }
    public int getTotalSeconds(){
        return hours*60*60+minutes*60+seconds;
    }

    @Override
    public String toString(){
        return hours+" hours, "+minutes+" minutes,"+seconds+" seconds\n";
    }

    @Override
    public int compareTo(Clock clock){
        if(this.getTotalSeconds()>clock.getTotalSeconds())
            return 1;
        else if (this.getTotalSeconds()< clock.getTotalSeconds()) {
            return -1;
        }
        else return 0;
    }
}
