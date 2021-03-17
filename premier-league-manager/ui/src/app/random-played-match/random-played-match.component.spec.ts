import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RandomPlayedMatchComponent } from './random-played-match.component';

describe('RandomPlayedMatchComponent', () => {
  let component: RandomPlayedMatchComponent;
  let fixture: ComponentFixture<RandomPlayedMatchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RandomPlayedMatchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RandomPlayedMatchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
