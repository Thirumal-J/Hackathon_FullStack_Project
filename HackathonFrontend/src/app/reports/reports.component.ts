import { Component, OnInit } from '@angular/core';
import { EventinfoService } from '../eventinfo.service';
import { FeedbackService } from '../feedback.service';
import { Distinctevents } from '../distinctevents';
import * as Chart from 'chart.js';
// import {Chart } from 'chart.js';
@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent {

  distinctevents: Distinctevents[];
  avg: number;
  json = [];
  data = [];
  event: string;
  public show: boolean = false;
  public buttonName: any = 'Show';
  selectedEvent: Distinctevents;

  chart: any = [];
  barChartLabels = ['5 rating', '4 rating', '3 rating', '2 rating', '1 rating'];
  report = [];

  constructor(private eventInfoService: EventinfoService) {
  }

  ngOnInit() {
    this.eventInfoService.findAllDistinct().subscribe(data => {
      this.distinctevents = data;
    });
    this.eventInfoService.getFeedbackReport().subscribe((res) => {
      this.json = res;
    });
  }

  onSelect(distinctEvent: Distinctevents): void {
    this.selectedEvent = distinctEvent;
    this.event = JSON.stringify(this.selectedEvent.eventId);


    this.avg = 0;
    Object.keys(this.json).forEach(element => {

      if (this.event === JSON.stringify(element)) {
        this.report = [this.json[element]['fiveStar'], this.json[element]['fourStar'],
        this.json[element]['threeStar'], this.json[element]['twoStar'], this.json[element]['oneStar']];
        this.avg = (5 * this.json[element]['fiveStar'] + 4 * this.json[element]['fourStar'] + 3 * this.json[element]['threeStar'] + 2 * this.json[element]['twoStar'] + 1 * this.json[element]['oneStar']) / (this.json[element]['fiveStar'] + this.json[element]['fourStar'] + this.json[element]['threeStar'] + this.json[element]['twoStar'] + this.json[element]['oneStar']);

        this.chart = new Chart('canvas', {
          type: 'horizontalBar',
          data: {
            labels: this.barChartLabels, // your labels array
            datasets: [
              {
                data: this.report, // your data array

                fill: false,
                backgroundColor: [
                  'rgba(255, 99, 132, 0.2)',
                  'rgba(54, 162, 235, 0.2)',
                  'rgba(255, 206, 86, 0.2)',
                  'rgba(75, 192, 192, 0.2)',
                  'rgba(153, 102, 255, 0.2)',
                  'rgba(255, 159, 64, 0.2)'
                ],
                borderColor: [
                  'rgba(255, 99, 132, 1)',
                  'rgba(54, 162, 235, 1)',
                  'rgba(255, 206, 86, 1)',
                  'rgba(75, 192, 192, 1)',
                  'rgba(153, 102, 255, 1)',
                  'rgba(255, 159, 64, 1)'
                ],
                borderWidth: 1
              }
            ]
          },
          options: {
            legend: {
              display: false
            },
            scales: {
              xAxes: [{
                stacked: true
              }],
              yAxes: [{
                stacked: true
              }]
            }
          }
        });
      }
    });
  }
}
