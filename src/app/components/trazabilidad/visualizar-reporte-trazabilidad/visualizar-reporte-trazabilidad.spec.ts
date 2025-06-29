import { ComponentFixture, TestBed } from '@angular/core/testing';
import { VisualizarReporteTrazabilidad } from './visualizar-reporte-trazabilidad';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('VisualizarReporteTrazabilidad', () => {
  let component: VisualizarReporteTrazabilidad;
  let fixture: ComponentFixture<VisualizarReporteTrazabilidad>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        VisualizarReporteTrazabilidad,
        HttpClientTestingModule,
        RouterTestingModule
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(VisualizarReporteTrazabilidad);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

