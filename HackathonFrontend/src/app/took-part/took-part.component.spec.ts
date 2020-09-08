import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TookPartComponent } from './took-part.component';

describe('TookPartComponent', () => {
  let component: TookPartComponent;
  let fixture: ComponentFixture<TookPartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [TookPartComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TookPartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
