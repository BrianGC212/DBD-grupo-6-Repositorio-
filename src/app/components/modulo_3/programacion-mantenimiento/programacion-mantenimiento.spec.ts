import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgramacionMantenimiento } from './programacion-mantenimiento';

describe('ProgramacionMantenimiento', () => {
  let component: ProgramacionMantenimiento;
  let fixture: ComponentFixture<ProgramacionMantenimiento>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProgramacionMantenimiento]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProgramacionMantenimiento);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
