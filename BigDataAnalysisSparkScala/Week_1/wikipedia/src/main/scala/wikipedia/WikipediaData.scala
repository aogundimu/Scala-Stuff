package wikipedia

import java.io.File

object WikipediaData {

  private[wikipedia] def filePath = {
    val resource = this.getClass.getClassLoader.getResource("wikipedia/wikipedia.dat")
    if (resource == null) sys.error("Please download the dataset as explained in the assignment instructions")
    //System.out.println("*************** FILEPATH DONE **************")
    new File(resource.toURI).getPath

  }

  private[wikipedia] def parse(line: String): WikipediaArticle = {
    val subs = "</title><text>"
    val i = line.indexOf(subs)
    val title = line.substring(14, i)
    val text  = line.substring(i + subs.length, line.length-16)
    //System.out.println("*************** PARSE DONE **************")
    WikipediaArticle(title, text)

  }
}
