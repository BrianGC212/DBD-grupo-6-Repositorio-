import { ComponentFixture, TestBed } from '@angular/core/testing';
import { VisualizarIncidencias } from './visualizar-incidencias';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('VisualizarIncidencias', () => {
  let component: VisualizarIncidencias;
  let fixture: ComponentFixture<VisualizarIncidencias>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        VisualizarIncidencias,
        HttpClientTestingModule,
        RouterTestingModule
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(VisualizarIncidencias);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
