import { Component } from '@angular/core';

@Component({
  selector: 'app-card-list',
  templateUrl: './card-list.component.html',
  styleUrls: ['./card-list.component.css'],
})
export class CardListComponent {
  arrayFotos: any = [
    {
      url: 'https://i.imgur.com/45wjiv9.jpeg',
      description:
        'Frodo drove off Shelob with Galadriel’s phial, which contained the light of Eärendil, the evening star, what we would call Venus. Eärendil in Middle Earth is an elven mariner sailing a flying ship that is lit with a Silmaril, a jewel that emits an immense radiance.  The light contained in the Silmarils came from the Two Trees of Valinor, Middle Earth’s precursors to the sun and moon, which had been destroyed by Ungoliant, Shelob’s mother.  ',
    },
    {
      url: 'https://i.imgur.com/io03IH5.jpeg',
      description:
        'When Samwise began to carry the Ring, it tried to corrupt him by offering him his deepest desires.  As Sam wanted to be a gardener, it showed him a vision of all of Mordor being turned into a massive garden for him to tend. Fortunately, the inherent absurdities of a nationwide garden allowed Sam to overcome its influence.',
    },
    {
      url: 'https://i.imgur.com/7qjvKyi.jpeg',
      description:
        'Gandalf was one of the lesser Ainur who entered Middle-Earth in the beginning of time. They were known as the Maiar, and were basically lesser spirits than the Valar who ruled the Earth, but existed before the creation. They were known to take on many forms or "veils" as they appeared in Middle-Earth. These veils or bodies could be destroyed, but their spirits could not.',
    },
    {
      url: 'https://i.imgur.com/Ns7F77q.jpeg',
      description:
        "Having been born into almost constant war, the weight of his father's depression is at the forefront of all of Boromir's decisions. Gondor is strong, but he sees that its strength is being beaten down. It's with his knowledge we begin to see that to Boromir, this Ring is exactly what Gondor needs to drive back the armies of Mordor and restore Gondor to its former glory.",
    },
    {
      url: 'https://i.imgur.com/0yyWICs.jpeg',
      description:
        'Forbes once calculated the net worth of Smaug’s hoard to be 62 billion dollars, making Smaug the second wealthiest fictional character in existence, only surpassed by Scrooge McDuck.',
    },
  ];
}
