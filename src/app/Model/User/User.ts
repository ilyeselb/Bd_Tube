import {Role} from './Account';
import {VideoRechercher} from '../VideoRechercher/VideoRechercher';

export  class User {
  Id_user: number;
  username: String;
  role: Role;
  password: String;
  videodemander: VideoRechercher[];
}
