import { ComponentFixture, TestBed } from '@angular/core/testing';
import { VisualizarProceso } from './visualizar-proceso';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('VisualizarProceso', () => {
  let component: VisualizarProceso;
  let fixture: ComponentFixture<VisualizarProceso>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        VisualizarProceso,
        HttpClientTestingModule,
        RouterTestingModule
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(VisualizarProceso);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
