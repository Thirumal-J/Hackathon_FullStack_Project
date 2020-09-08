import { Injectable } from '@angular/core';
import { Feedback } from './feedback';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  private feedbackUrl: string;

  constructor(private http: HttpClient) {
    this.feedbackUrl = 'http://localhost:8081/userAccount/postFeedback';
  }

  postFeedback(feedback : Feedback){
    console.log("in service.ts");
    return this.http.post<Feedback>(this.feedbackUrl, feedback);  
  }
}
