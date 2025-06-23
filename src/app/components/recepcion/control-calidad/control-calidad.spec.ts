import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ControlCalidad } from './control-calidad';

describe('ControlCalidad', () => {
  let component: ControlCalidad;
  let fixture: ComponentFixture<ControlCalidad>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ControlCalidad]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ControlCalidad);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
