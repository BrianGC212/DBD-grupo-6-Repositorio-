import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanificacionEquipos } from './planificacion-equipos';

describe('PlanificacionEquipos', () => {
  let component: PlanificacionEquipos;
  let fixture: ComponentFixture<PlanificacionEquipos>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PlanificacionEquipos]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlanificacionEquipos);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
