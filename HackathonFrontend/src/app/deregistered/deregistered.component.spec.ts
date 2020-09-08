import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeregisteredComponent } from './deregistered.component';

describe('DeregisteredComponent', () => {
  let component: DeregisteredComponent;
  let fixture: ComponentFixture<DeregisteredComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeregisteredComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeregisteredComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
