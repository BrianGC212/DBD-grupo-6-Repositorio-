import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarSeguimiento } from './registrar-seguimiento';

describe('RegistrarSeguimiento', () => {
  let component: RegistrarSeguimiento;
  let fixture: ComponentFixture<RegistrarSeguimiento>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistrarSeguimiento]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrarSeguimiento);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
