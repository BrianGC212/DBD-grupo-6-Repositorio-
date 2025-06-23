import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarGuiaRemision } from './registrar-guia-remision';

describe('RegistrarGuiaRemision', () => {
  let component: RegistrarGuiaRemision;
  let fixture: ComponentFixture<RegistrarGuiaRemision>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistrarGuiaRemision]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrarGuiaRemision);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
