package com.yape.pe.models.booking;

public final class BookingBuilder {

  private String firstname;
  private String lastname;
  private Integer totalprice;
  private Boolean depositpaid;
  private Bookingdates bookingdates;
  private String additionalneeds;

  private BookingBuilder() {
  }

  public static BookingBuilder aBooking() {
    return new BookingBuilder();
  }

  public BookingBuilder withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public BookingBuilder withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public BookingBuilder withTotalprice(Integer totalprice) {
    this.totalprice = totalprice;
    return this;
  }

  public BookingBuilder withDepositpaid(Boolean depositpaid) {
    this.depositpaid = depositpaid;
    return this;
  }

  public BookingBuilder withBookingdates(Bookingdates bookingdates) {
    this.bookingdates = bookingdates;
    return this;
  }

  public BookingBuilder withAdditionalneeds(String additionalneeds) {
    this.additionalneeds = additionalneeds;
    return this;
  }

  public Booking build() {
    Booking booking = new Booking();
    booking.setFirstname(firstname);
    booking.setLastname(lastname);
    booking.setTotalprice(totalprice);
    booking.setDepositpaid(depositpaid);
    booking.setBookingdates(bookingdates);
    booking.setAdditionalneeds(additionalneeds);
    return booking;
  }
}
