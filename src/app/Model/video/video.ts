import {Chanel} from '../Chanel/Chanel';
import {User} from '../User/User';

export  class Video {
  id_video: String;
  title: String;
  lien: String;
  imgUrl: String;
  url_feed: String;
  publishDate: String;
  description: String;
  categorie: String;
  acceptation: number;
  chanel: Chanel;
}
