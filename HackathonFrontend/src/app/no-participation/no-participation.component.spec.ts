import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NoParticipationComponent } from './no-participation.component';

describe('NoParticipationComponent', () => {
  let component: NoParticipationComponent;
  let fixture: ComponentFixture<NoParticipationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NoParticipationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NoParticipationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
