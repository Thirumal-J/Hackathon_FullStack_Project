import { Component, OnInit } from '@angular/core';
import { ViewEncapsulation } from '@angular/core'
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { FeedbackService } from '../feedback.service';
import { Router } from '@angular/router';
import { Feedback } from '../feedback';
declare var jquery: any;
declare var $: any;

@Component({
    selector: 'app-took-part',
    templateUrl: './took-part.component.html',
    styleUrls: ['./took-part.component.css'],
})
export class TookPartComponent implements OnInit {
    path: any;
    feedback: Feedback;
    feedbackForm: FormGroup;
    constructor(fb: FormBuilder, private router: Router, private feedbackService: FeedbackService) {
        this.feedbackForm = fb.group({
            rating: ['', Validators.required],
            comment1: ['', Validators.required],
            comment2: ['', Validators.required]
        });
        this.path = this.router.url;
    }

    ngOnInit() {

    }



    toggleSmiley1() {
        $(".smiley1").toggleClass("test");
        $(".smiley1").siblings().removeClass("test");
    }
    toggleSmiley2() {
        $(".smiley2").toggleClass("test");
        $(".smiley2").siblings().removeClass("test");
    }
    toggleSmiley3() {
        $(".smiley3").toggleClass("test");
        $(".smiley3").siblings().removeClass("test");
    }
    toggleSmiley4() {
        $(".smiley4").toggleClass("test");
        $(".smiley4").siblings().removeClass("test");
    }
    toggleSmiley5() {
        $(".smiley5").toggleClass("test");
        $(".smiley5").siblings().removeClass("test");
    }

    onSubmit() {
        // TODO: Use EventEmitter with form value
        console.warn(this.feedbackForm.value);
        var str = this.path;
        var splitted = str.split("/", 4);
        console.log(splitted[2]);
        var json = {
            empid: splitted[2],
            eventid: splitted[3],
            rating: this.feedbackForm.value.rating,
            likedabout: this.feedbackForm.value.comment1,
            improvement: this.feedbackForm.value.comment2
        }

        this.feedback = new Feedback(json.empid, json.eventid, json.rating, json.likedabout, json.improvement);
        console.log(this.feedback);
        this.feedbackService.postFeedback(this.feedback).subscribe(data => {
        });

        window.alert("Thanks for your feedback.");
        this.router.navigate(['/dashboard']);
    }
}
