export class Feedback {
    id: number;
    empId: number;
    eventId: string;
    rating: number;
    likeAbout: string;
    improvement: string;
    constructor(empId: number,eventId: string, rating: number, likedAbout: string , improvement: string)
    {
        this.empId= empId;
        this.eventId=eventId;
        this.rating=rating;
        this.likeAbout=likedAbout;
        this.improvement=improvement;
    }
    // get iD(): number {
    //     return this.id;
    // }

    // set iD(id: number) {
    //     this.id = id;
    // }

    // get empid(): number {
    //     return this.empId;
    // }

    // set empid(empId: number) {
    //     this.id = empId;
    // }

    // get eventid(): string {
    //     return this.eventId;
    // }

    // set eventid(eventId: string) {
    //     this.eventId = eventId;
    // }

    // get Rating(): number {
    //     return this.rating;
    // }

    // set Rating(rating: number) {
    //     this.rating = rating;
    // }

    // get likedabout(): string {
    //     return this.likedAbout;
    // }

    // set likedabout(likedAbout: string) {
    //     this.likedAbout = likedAbout;
    // }
    // get Improvement(): string {
    //     return this.improvement;
    // }

    // set Improvement(improvement: string) {
    //     this.improvement = improvement;
    // }
}
