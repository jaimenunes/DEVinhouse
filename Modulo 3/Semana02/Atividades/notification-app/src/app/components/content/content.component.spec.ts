import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ContentComponent } from './content.component';
import { NotificationService } from 'src/app/services/notification.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { AppModule } from 'src/app/app.module';

describe('ContentComponent', () => {
  let component: ContentComponent;
  let fixture: ComponentFixture<ContentComponent>;
  let service: NotificationService;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, AppModule],
      declarations: [ContentComponent],
      providers: [NotificationService],
    }).compileComponents();
    service = TestBed.inject(NotificationService);
    fixture = TestBed.createComponent(ContentComponent);
    component = fixture.componentInstance;
  });

  it('Should create component', () => {
    expect(component).toBeTruthy();
  });
});
