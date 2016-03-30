import {Component, OnInit} from 'angular2/core';

@Component({
  selector: 'app-menu', //Makes it possible to use <app-menu> to insert this component. See app.html
  templateUrl: 'app/templates/menu.html' //The template (view) of this component
})

//Component corresponds to the controller in MVC, or the view model in MVVM
export class MenuComponent implements OnInit {
  //Parameters of the constructor are inserted automatically by Angular 2
  constructor() {}
  
  onAbout() {
    alert("Created by ...");
  }
  
  ngOnInit() {}
}
