import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionEquiposComponent } from './gestion-equipos';

describe('GestionEquipos', () => {
  let component: GestionEquiposComponent;
  let fixture: ComponentFixture<GestionEquiposComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GestionEquiposComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GestionEquiposComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
