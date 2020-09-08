import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserServiceService } from '../user-service.service';
import { EventinfoService } from '../eventinfo.service';
import { User } from '../user';
import { Eventinfo } from '../eventinfo';
declare var jquery: any;
declare var $: any;
@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html',
  styleUrls: ['./roles.component.css']
})
export class RolesComponent implements OnInit {

  events: Eventinfo[];

  constructor(private eventInfoService: EventinfoService) {
  }

  ngOnInit() {
    this.eventInfoService.findAll().subscribe(data => {
      this.events = data;
    });
  }


  filter() {
    $("#myInput").on("keyup", function () {
      var value = $(this).val().toLowerCase();
      $("#myTable tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
      });
    });
  }

}
