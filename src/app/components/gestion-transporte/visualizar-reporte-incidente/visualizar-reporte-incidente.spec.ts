import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisualizarReporteIncidente } from './visualizar-reporte-incidente';

describe('VisualizarReporteIncidente', () => {
  let component: VisualizarReporteIncidente;
  let fixture: ComponentFixture<VisualizarReporteIncidente>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VisualizarReporteIncidente]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VisualizarReporteIncidente);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
