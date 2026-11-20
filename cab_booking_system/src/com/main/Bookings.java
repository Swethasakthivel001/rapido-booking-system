package com.main;

public class Bookings {
    private int bookingid;
    private int userid;
    private String name;
    private String vehical;
    private Boolean bookingstatus;
    private Boolean cancel;
    private static int bookingno = 0;
    
    public Bookings(int userid, String name, String vehical, Boolean bookingstatus, Boolean cancel)
    {
        this.bookingid = ++bookingno;
        this.userid = userid;
        this.name = name;
        this.vehical = vehical;
        this.bookingstatus = bookingstatus;
        this.cancel = cancel;
    }

    public Bookings(int bookingid, int userid, String name, String vehical, Boolean bookingstatus, Boolean cancel)
    {
        this.bookingid = bookingid;
        this.userid = userid;
        this.name = name;
        this.vehical = vehical;
        this.bookingstatus = bookingstatus;
        this.cancel = cancel;
    }

    public int getbookingid()
    {
        return bookingid;
    }

    public void setbookingid(int bookingid)
    {
        this.bookingid = bookingid;
    }

    public int getUserid()
    {
        return userid;
    }

    public void setUserid(int  userid)
    {
        this.userid = userid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getVehical()
    {
        return vehical;
    }

    public void setVehical(String vehical)
    {
        this.vehical = vehical;
    }

    public Boolean getBookingstatus()
    {
        return bookingstatus;
    }

    public void setBookingstatus(Boolean bookingstatus)
    {
        this.bookingstatus = bookingstatus;
    }

    public Boolean getCancel()
    {
        return cancel;
    }

    public void setCancel(Boolean cancel)
    {
        this.cancel = cancel;
    }

    @Override 
    public String toString(){
        return "BookingID = " +  getbookingid() + ", Vehical = " + getVehical() + ", Booking Status = " + getBookingstatus() + ", Cancelled Rides = " + getCancel();
    }
}
