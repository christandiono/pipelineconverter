package Taverna.Tree;
import Taverna.Tree.TavernaNode;

public class RetryConfig extends TavernaNode {

double backoffFactor;
long initialDelay;
long maxDelay;
int maxRetries;
}