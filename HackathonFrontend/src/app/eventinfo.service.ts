import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Eventinfo } from './eventinfo';
import { Distinctevents } from './distinctevents';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EventinfoService {
  private empData: string;
  private distinctEvents: string;
  private feedbackReport: string;

  constructor(private http: HttpClient) {
    this.empData = 'http://localhost:8081/userAccount/getEventInfo';
    this.distinctEvents = 'http://localhost:8081/userAccount/getDistinctEvents';
    this.feedbackReport = 'http://localhost:8081/userAccount/getFeedbackReport';
  }

  private extractData(res: Response) {
    let body = res;
    return body || {};
  }
  public findAll(): Observable<Eventinfo[]> {
    return this.http.get<Eventinfo[]>(this.empData);
  }
  public findAllDistinct(): Observable<Distinctevents[]> {
    return this.http.get<Distinctevents[]>(this.distinctEvents);
  }
  public getFeedbackReport(): Observable<any> {
    return this.http.get(this.feedbackReport).pipe(
      map(this.extractData));
  }
}
