package com.main;

public class ApprovedBooking extends Bookings{

    private int driverid;

    public ApprovedBooking(int bookingid, int userid, String name, String vehical, Boolean bookingstatus,Boolean cancel, int driverid){
        super(bookingid, userid, name, vehical, bookingstatus, cancel);
        this.driverid = driverid;
    }

    public int getDriverid()
    {
        return driverid;
    }

    public void setDriverid(int driverid)
    {
        this.driverid = driverid;
    }

    @Override 
    public String toString()
    {
        return "BookingID = " + getbookingid() + ", vehical = " + getVehical() + ", BookingStatus = " + getBookingstatus() + ", Cancel = " + getCancel();
    }
}
