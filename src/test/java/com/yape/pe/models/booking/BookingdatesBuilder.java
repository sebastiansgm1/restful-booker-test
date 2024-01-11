package com.yape.pe.models.booking;

public final class BookingdatesBuilder {

  private String checkin;
  private String checkout;

  private BookingdatesBuilder() {
  }

  public static BookingdatesBuilder aBookingdates() {
    return new BookingdatesBuilder();
  }

  public BookingdatesBuilder withCheckin(String checkin) {
    this.checkin = checkin;
    return this;
  }

  public BookingdatesBuilder withCheckout(String checkout) {
    this.checkout = checkout;
    return this;
  }

  public Bookingdates build() {
    Bookingdates bookingdates = new Bookingdates();
    bookingdates.setCheckin(checkin);
    bookingdates.setCheckout(checkout);
    return bookingdates;
  }
}
