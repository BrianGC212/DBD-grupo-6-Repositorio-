import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ControlInventarios } from './control-inventarios';

describe('ControlInventarios', () => {
  let component: ControlInventarios;
  let fixture: ComponentFixture<ControlInventarios>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ControlInventarios]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ControlInventarios);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
