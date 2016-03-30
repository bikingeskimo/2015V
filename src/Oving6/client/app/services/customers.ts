//The classes Customer and CustomersService corresponds to the model in MVC and MVVM

var nextCustomerId = 1;

export class Customer {
  public id:number;
  name:string;
  city:string;
  constructor(name:string="", city:string="") {
    if(name!="") {
      this.id = nextCustomerId++;
      this.name=name;
      this.city=city;
    }
  }
}

//The class CustomersService is a singleton that is initialized in app.ts, that is when the application is loaded
//In the next lecture, CustomersService will be modified so that the customer data will be read from a server instead
export class CustomersService {
  customers:Customer[]=[];
  
  constructor() {
    this.customers.push(new Customer("Ola", "Trondheim"));
    this.customers.push(new Customer("Kari", "Oslo"));
    this.customers.push(new Customer("Per", "Tromsø"));
  }
  
  getCustomers():Customer[] {
    return this.customers;
  }
  
  getCustomer(id:number):Customer {
    for(var c=0;c<this.customers.length;c++) {
      if(this.customers[c].id==id) {
        return this.customers[c];
      }
    }
  }
  
  addCustomer(name:string, city:string) {
    this.customers.push(new Customer(name, city));
  }
}