import {Component, OnInit} from 'angular2/core';
import {Router} from 'angular2/router';

import {Customer, CustomersService} from '../services/customers';

@Component({
  templateUrl: 'app/templates/customers.html' //The template (view) of this component
})

//Component corresponds to the controller in MVC, or the view model in MVVM
export class CustomersComponent implements OnInit {
  customers:Customer[];
  
  //Parameters of the constructor are inserted automatically by Angular 2
  //With private in front of a parameter, the parameter becomes a class member
  constructor(private customersService:CustomersService, private router:Router) {
    this.customers=customersService.getCustomers();
  }
  
  onSelect(customer_id:number) {
    this.router.navigate(['CustomerPath', {id: customer_id}]);
  }
  
  onNewCustomer(name:string, city:string) {
    this.customersService.addCustomer(name, city);
  }
  
  ngOnInit() {}
}
