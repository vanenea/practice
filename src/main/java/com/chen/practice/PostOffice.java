package com.chen.practice;

import java.util.Iterator;

class Mail{
	enum GeneralDelivery {YES,NO1,NO2,NO3,NO4,NO5}
	enum Scannability {UNSCANNABLE,YES1,YES2,YES3,YES4}
	enum Readability {ILLEGIBLE,YES1,YES2,YES3,YES4}
	enum Address {INCORRECT,OK1,OK2,OK3,OK4,OK5,OK6}
	enum ReturnAddress {MISSING,OK1,OK2,OK3,OK4,OK5}
	GeneralDelivery generalDelivery;
	Scannability scannability;
	Readability readability;
	Address address;
	ReturnAddress returnAddress;
	
	
	public static Mail randomMail() {
		Mail mail = new Mail();
		mail.generalDelivery = Enums.random(GeneralDelivery.class);
		mail.scannability = Enums.random(Scannability.class);
		mail.readability = Enums.random(Readability.class);
		mail.address = Enums.random(Address.class);
		mail.returnAddress = Enums.random(ReturnAddress.class);
		return mail;
	}
	
	static long counter = 0;
	long id = counter ++;
	@Override
	public String toString() {
		return "Mail " +id;
	}
	
	public String detail() {
		return toString()+", generalDelivery:"+generalDelivery
				+", scannability:"+scannability
				+", readability:"+readability
				+", address:"+address
				+", returnAddress:"+returnAddress;
	}


	public static Iterable<Mail> generator(final int count){
		return new Iterable<Mail>() {
			int n = count;
			@Override
			public Iterator<Mail> iterator() {
				return new Iterator<Mail>() {
					@Override
					public boolean hasNext() {
						return n-->0;
					}
					@Override
					public Mail next() {
						return randomMail();
					}
					@Override
					public void remove() {
						throw new  UnsupportedOperationException();
					}
				};
			}
		};
		
	}
	
}

public class PostOffice {
	
	enum MailHandler{
		GENERAL_DELIVERY{
			boolean handle(Mail mail) {
				switch(mail.generalDelivery) {
				case YES:
					System.out.println("Using general delivery for " + mail);	
					return true;
				default:
					return false;
				}
			}
		},
		MACHINE_SCAN{
			boolean handle(Mail mail) {
				switch(mail.scannability) {
		          case UNSCANNABLE: 
		        	  return false;
		          default:
		            switch(mail.address) {
		              case INCORRECT: return false;
		              default:
		                System.out.println("Delivering "+ mail + " automatically");
		                return true;
		            }
		        }
			}
		},
		VISUAL_INSPECTION{
			boolean handle(Mail mail) {
				 switch(mail.readability) {
		          case ILLEGIBLE: 
		        	  return false;
		          default:
		            switch(mail.address) {
		              case INCORRECT: 
		            	  return false;
		              default:
		                System.out.println("Delivering " + mail + " normally");
		                return true;
		            }
		        }
			}
		},
		RETURN_TO_SENDER{
			boolean handle(Mail mail) {
		        switch(mail.returnAddress) {
		          case MISSING: 
		        	  return false;
		          default:
		            System.out.println("Returning " + mail + " to sender");
		            return true;
		        }
		      }
		};
		abstract boolean handle(Mail mail);
		
	}
	static void handle(Mail mail) {
		for (MailHandler mailHandler : MailHandler.values()) {
			if(mailHandler.handle(mail))
				return ;
		}
		System.out.println(mail + " is a dead letter"); 
	}
	
	public static void main(String[] args) {
		for(Mail mail : Mail.generator(10)) {
			System.out.println(mail.detail());
			handle(mail);
			System.out.println("-----------");
		}
	}
}
